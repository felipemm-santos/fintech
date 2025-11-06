"use client";
import DropdownOption from "@/components/DropdownOption";
import { Goal } from "@/interfaces/goal.interface";
import { useParams, useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function GoalEditPage() {
  const { id } = useParams();
  const [goal, setGoal] = useState<Goal | null>(null);
  const [targetDate, setTargetDate] = useState("");
  const [completionDate, setCompletionDate] = useState("");
  const [status, setStatus] = useState("");
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState<string | null>(null);
  const router = useRouter();

  useEffect(() => {
    async function fetchGoal() {
      try {
        const res = await fetch(`/api/dashboard/goals/${id}`);
        if (res.ok) {
          const data = await res.json();
          setGoal(data);
          setTargetDate(data.targetDate ? data.targetDate.toString() : "");
          setCompletionDate(
            data.completionDate ? data.completionDate.toString() : ""
          );
          setStatus(data.status === 1 ? "Concluído" : "Em Progresso");
        } else {
          throw new Error("Objetivo não encontrada");
        }
      } catch (err) {
        setError((err as Error).message);
      } finally {
        setLoading(false);
      }
    }
    fetchGoal();
  }, [id]);

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    if (!goal) return;

    try {
      const res = await fetch(`/api/dashboard/goals/${goal.id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({
          ...goal,
          targetDate,
          completionDate,
          status: status == "Concluído" ? 1 : 0,
        }),
      });

      if (!res.ok) {
        const body = await res.json();
        throw new Error(body.message || "Falha ao atualizar objetivo");
      }

      router.push("/dashboard/objetivos");
    } catch (err: unknown) {
      setError((err as Error).message);
    }
  };

  if (loading) return <p className="mt-6">Carregando...</p>;
  if (error) return <p className="mt-6 text-red-600">{error}</p>;
  if (!goal) return <p className="mt-6">Objetivo não encontrada.</p>;

  return (
    <main className="container mx-auto p-8 ">
      <h1 className="text-3xl font-bold mb-6 text-center">Editar Objetivo</h1>
      <form
        onSubmit={handleSubmit}
        className="w-sm mx-auto bg-white p-6 rounded shadow-lg"
      >
        {error && <p className="text-red-600">{error}</p>}
        <div className="mt-4">
          <label className="block text-sm font-medium">Nome</label>
          <input
            value={goal.name}
            onChange={(e) => setGoal({ ...goal, name: e.target.value })}
            type="text"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Valor desejado</label>
          <input
            value={goal.targetAmount}
            onChange={(e) =>
              setGoal({ ...goal, targetAmount: parseFloat(e.target.value) })
            }
            type="number"
            step="0.01"
            required
            className="mt-1 w-full p-2 border rounded"
          />
        </div>
        <div className="mt-4">
          <label className="block text-sm font-medium">Valor atual</label>
          <input
            value={goal.currentAmount}
            onChange={(e) =>
              setGoal({ ...goal, currentAmount: parseFloat(e.target.value) })
            }
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
            value={goal.description ? goal.description : ""}
            onChange={(e) => setGoal({ ...goal, description: e.target.value })}
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
