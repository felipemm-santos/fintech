"use client";
import { Expense } from "@/interfaces/expense.interface";
import { useParams, useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function ExpenseEditPage() {
  const { id } = useParams();
  const [expense, setExpense] = useState<Expense | null>(null);
  const [dueDate, setDueDate] = useState("");
  const [paymentDate, setPaymentDate] = useState("");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const router = useRouter();

  useEffect(() => {
    async function fetchExpense() {
      try {
        const res = await fetch(`/api/dashboard/expenses/${id}`);
        if (res.ok) {
          const data = await res.json();
          setExpense(data);
          setDueDate(data.dueDate ? data.dueDate.toString() : "");
          setPaymentDate(data.paymentDate ? data.paymentDate.toString() : "");
        } else {
          throw new Error("Despesa não encontrada");
        }
      } catch (err) {
        setError((err as Error).message);
      } finally {
        setLoading(false);
      }
    }
    fetchExpense();
  }, [id]);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!expense) return;

    try {
      const res = await fetch(`/api/dashboard/expenses/${expense.id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ ...expense, dueDate, paymentDate }),
      });

      if (!res.ok) {
        const body = await res.json();
        throw new Error(body.message || "Falha ao atualizar despesa");
      }

      router.push("/dashboard/despesas");
    } catch (err: unknown) {
      setError((err as Error).message);
    }
  };

  if (loading) return <p className="mt-6">Carregando...</p>;
  if (error) return <p className="mt-6 text-red-600">{error}</p>;
  if (!expense) return <p className="mt-6">Despesa não encontrada.</p>;

  return (
    <main className="container mx-auto p-8 ">
      <h1 className="text-3xl font-bold mb-6 text-center">Editar Despesa</h1>
      <form
        onSubmit={handleSubmit}
        className="w-sm mx-auto bg-white p-6 rounded shadow-lg"
      >
        {error && <p className="text-red-600">{error}</p>}
        <div className="mt-4">
          <label className="block text-sm font-medium">Id Categoria</label>
          <input
            value={expense.categoryId}
            onChange={(e) =>
              setExpense({
                ...expense,
                categoryId: parseInt(e.target.value, 10),
              })
            }
            type="text"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Descrição</label>
          <input
            value={expense.description}
            onChange={(e) =>
              setExpense({
                ...expense,
                description: e.target.value,
              })
            }
            type="text"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Valor</label>
          <input
            value={expense.value}
            onChange={(e) =>
              setExpense({
                ...expense,
                value: parseFloat(e.target.value),
              })
            }
            type="number"
            step="0.01"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Status</label>
          <input
            value={expense.status}
            onChange={(e) =>
              setExpense({
                ...expense,
                status: e.target.value,
              })
            }
            type="text"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">
            Data de Vencimento
          </label>
          <input
            value={dueDate}
            onChange={(e) => setDueDate(e.target.value)}
            type="date"
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Data de Pagamento</label>
          <input
            value={paymentDate}
            onChange={(e) => setPaymentDate(e.target.value)}
            type="date"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <button className="mt-4 w-full bg-blue-600 text-white py-2 rounded">
          Salvar Despesa
        </button>
      </form>
    </main>
  );
}
