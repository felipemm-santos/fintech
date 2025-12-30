"use client";
import { Income } from "@/interfaces/income.interface";
import { useParams, useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function IncomeEditPage() {
  const { id } = useParams();
  const [income, setIncome] = useState<Income | null>(null);
  const [dueDate, setDueDate] = useState("");
  const [paymentDate, setPaymentDate] = useState("");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const router = useRouter();

  useEffect(() => {
    async function fetchIncome() {
      try {
        const res = await fetch(`/api/dashboard/incomes/${id}`);
        if (res.ok) {
          const data = await res.json();
          setIncome(data);
          setDueDate(data.dueDate ? data.dueDate.toString() : "");
          setPaymentDate(data.paymentDate ? data.paymentDate.toString() : "");
        } else {
          throw new Error("Receita não encontrada");
        }
      } catch (err) {
        setError((err as Error).message);
      } finally {
        setLoading(false);
      }
    }
    fetchIncome();
  }, [id]);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!income) return;

    try {
      const res = await fetch(`/api/dashboard/incomes/${income.id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ ...income, dueDate, paymentDate }),
      });

      if (!res.ok) {
        const body = await res.json();
        throw new Error(body.message || "Falha ao atualizar receita");
      }

      router.push("/dashboard/receitas");
    } catch (err: unknown) {
      setError((err as Error).message);
    }
  };

  if (loading) return <p className="mt-6">Carregando...</p>;
  if (error) return <p className="mt-6 text-red-600">{error}</p>;
  if (!income) return <p className="mt-6">Receita não encontrada.</p>;

  return (
    <main className="container mx-auto p-8 ">
      <h1 className="text-3xl font-bold mb-6 text-center">Editar Receita</h1>
      <form
        onSubmit={handleSubmit}
        className="w-sm mx-auto bg-white p-6 rounded shadow-lg"
      >
        {error && <p className="text-red-600">{error}</p>}
        <div className="mt-4">
          <label className="block text-sm font-medium">Id Categoria</label>
          <input
            value={income.categoryId}
            onChange={(e) =>
              setIncome({
                ...income,
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
            value={income.description}
            onChange={(e) =>
              setIncome({
                ...income,
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
            value={income.value}
            onChange={(e) =>
              setIncome({
                ...income,
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
            value={income.status}
            onChange={(e) =>
              setIncome({
                ...income,
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
          Salvar Receita
        </button>
      </form>
    </main>
  );
}
