"use client";
import DropdownOption from "@/components/DropdownOption";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function NewGoalPage() {
  const userId = 1; // Substitua pelo ID do usuário autenticado
  const [name, setName] = useState("");
  const [targetAmount, setTargetAmount] = useState("");
  const [currentAmount, setCurrentAmount] = useState("");
  const [targetDate, setTargetDate] = useState("");
  const [status, setStatus] = useState("");
  const [description, setDescription] = useState("");
  const [completionDate, setCompletionDate] = useState("");
  const [error, setError] = useState<string | null>(null);
  const router = useRouter();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);

    try {
      const res = await fetch("/api/dashboard/goals", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          userId,
          name,
          targetAmount: parseFloat(targetAmount),
          currentAmount: parseFloat(currentAmount),
          targetDate,
          status: status === "Concluído" ? 1 : 0,
          description,
          completionDate,
          createdAt: new Date(),
        }),
      });

      if (!res.ok) {
        const body = await res.json();
        throw new Error(body.message || "Falha ao criar objetivo");
      }

      router.push("/dashboard/objetivos");
    } catch (err: unknown) {
      setError((err as Error).message);
    }
  };

  return (
    <main className="container mx-auto p-8 ">
      <h1 className="text-3xl font-bold mb-6 text-center">Nova Objetivo</h1>
      <form
        onSubmit={handleSubmit}
        className="w-sm mx-auto bg-white p-6 rounded shadow-lg"
      >
        {error && <p className="text-red-600">{error}</p>}
        <div className="mt-4">
          <label className="block text-sm font-medium">Nome</label>
          <input
            value={name}
            onChange={(e) => setName(e.target.value)}
            type="text"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Valor desejado</label>
          <input
            value={targetAmount}
            onChange={(e) => setTargetAmount(e.target.value)}
            type="number"
            step="0.01"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Valor atual</label>
          <input
            value={currentAmount}
            onChange={(e) => setCurrentAmount(e.target.value)}
            type="number"
            step="0.01"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Data Final</label>
          <input
            value={targetDate}
            onChange={(e) => setTargetDate(e.target.value)}
            type="date"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <DropdownOption
          id="status"
          label="Status"
          options={[
            { value: "Em Progresso", label: "Em Progresso" },
            { value: "Concluído", label: "Concluído" },
          ]}
          onChange={setStatus}
          divClassName="mt-4"
          labelClassName="block text-sm font-medium"
          selectClassName="mt-1 w-full p-2 border rounded"
        />
        <div className="mt-4">
          <label className="block text-sm font-medium">Descrição</label>
          <input
            value={description ? description : ""}
            onChange={(e) => setDescription(e.target.value)}
            type="text"
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Data de Conclusão</label>
          <input
            value={completionDate ? completionDate : ""}
            onChange={(e) => setCompletionDate(e.target.value)}
            type="date"
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <button className="mt-4 w-full bg-blue-600 text-white py-2 rounded">
          Salvar Objetivo
        </button>
      </form>
    </main>
  );
}
