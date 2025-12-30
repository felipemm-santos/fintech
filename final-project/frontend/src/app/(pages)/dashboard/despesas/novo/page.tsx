"use client";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function NewExpensePage() {
  const userId = 1; // Substitua pelo ID do usuário autenticado
  const [categoryId, setCategoryId] = useState("");
  const [description, setDescription] = useState("");
  const [value, setValue] = useState("");
  const [status, setStatus] = useState("");
  const [dueDate, setDueDate] = useState("");
  const [paymentDate, setPaymentDate] = useState("");
  const [error, setError] = useState<string | null>(null);
  const router = useRouter();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    try {
      const res = await fetch("/api/dashboard/expenses", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          userId,
          categoryId: parseInt(categoryId, 10),
          description,
          value: parseFloat(value),
          status,
          dueDate,
          paymentDate,
          createdAt: new Date(),
        }),
      });

      if (!res.ok) {
        const body = await res.json();
        throw new Error(body.message || "Falha ao criar despesa");
      }

      router.push("/dashboard/despesas");
    } catch (err: unknown) {
      setError((err as Error).message);
    }
  };

  return (
    <main className="container mx-auto p-8 ">
      <h1 className="text-3xl font-bold mb-6 text-center">Nova Despesa</h1>
      <form
        onSubmit={handleSubmit}
        className="w-sm mx-auto bg-white p-6 rounded shadow-lg"
      >
        {error && <p className="text-red-600">{error}</p>}
        <div className="mt-4">
          <label className="block text-sm font-medium">Id Categoria</label>
          <input
            value={categoryId}
            onChange={(e) => setCategoryId(e.target.value)}
            type="text"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Descrição</label>
          <input
            value={description}
            onChange={(e) => setDescription(e.target.value)}
            type="text"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Valor</label>
          <input
            value={value}
            onChange={(e) => setValue(e.target.value)}
            type="number"
            step="0.01"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Status</label>
          <input
            value={status}
            onChange={(e) => setStatus(e.target.value)}
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
