"use client";

import ButtonLink from "@/components/ButtonLink";
import { Goal } from "@/interfaces/goal.interface";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function DashboardGoalPage() {
  const [goals, setGoals] = useState<Goal[]>([]);
  const [loading, setLoading] = useState(true);
  const router = useRouter();

  useEffect(() => {
    const token = localStorage.getItem("user_token");
    if (!token) {
      router.push("/login");
      return;
    }

    async function fetchGoals() {
      try {
        const response = await fetch("/api/dashboard/goals");
        if (!response.ok) {
          throw new Error("Erro na resposta da API");
        }
        const data = await response.json();
        setGoals(data);
      } catch (error) {
        console.error("Erro ao buscar objetivos:", error);
      } finally {
        setLoading(false);
      }
    }

    fetchGoals();
  }, [router]);

  const handleDelete = async (id: number) => {
    if (!confirm("Deseja realmente excluir este objetivo?")) return;

    const res = await fetch(`/api/dashboard/goals/${id}`, {
      method: "DELETE",
    });
    if (res.ok) {
      setGoals((prev) => prev.filter((e) => e.id !== id));
    } else {
      alert("Falha ao excluir o objetivo.");
    }
  };

  return (
    <main className="container mx-auto p-6">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold">Objetivos</h1>
        <ButtonLink
          href="/dashboard/objetivos/novo"
          text="Novo Objetivo"
          color="bg-green-600 text-white"
          hoverColor="hover:bg-green-800"
        />
      </div>

      {loading ? (
        <p className="mt-6">Carregando...</p>
      ) : (
        <div className=" mt-6  overflow-x-auto">
          <table className="min-w-full bg-white border text-center">
            <thead>
              <tr>
                <th className="px-6 py-3 border-b">ID</th>
                <th className="px-6 py-3 border-b">Nome</th>
                <th className="px-6 py-3 border-b">Valor desejado</th>
                <th className="px-6 py-3 border-b">Valor Atual</th>
                <th className="px-6 py-3 border-b">Data Final</th>
                <th className="px-6 py-3 border-b">Status</th>
                <th className="px-6 py-3 border-b">Descrição</th>
                <th className="px-6 py-3 border-b">Data de cumprimento</th>
                <th className="px-6 py-3 border-b">Ações</th>
              </tr>
            </thead>
            <tbody>
              {goals.length === 0 && (
                <tr>
                  <td colSpan={7} className="px-6 py-4 text-center">
                    Nenhum objetivo encontrado.
                  </td>
                </tr>
              )}
              {goals.map((goal) => (
                <tr key={goal.id}>
                  <td className="px-6 py-4 border-b">{goal.id}</td>
                  <td className="px-6 py-4 border-b">{goal.name}</td>
                  <td className="px-6 py-4 border-b">
                    R${" "}
                    {goal.targetAmount.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    })}
                  </td>
                  <td className="px-6 py-4 border-b">
                    R${" "}
                    {goal.currentAmount.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    })}
                  </td>
                  <td className="px-6 py-4 border-b">
                    {goal.targetDate
                      ? new Date(goal.targetDate).toLocaleDateString()
                      : "-"}
                  </td>
                  <td className="px-6 py-4 border-b">
                    {goal.status == 1 ? "Concluído" : "Em Progresso"}
                  </td>
                  <td className="px-6 py-4 border-b">{goal.description}</td>
                  <td className="px-6 py-4 border-b">
                    {goal.completionDate
                      ? new Date(goal.completionDate).toLocaleDateString()
                      : "-"}
                  </td>
                  <td className="px-6 py-4 border-b">
                    <div className="flex justify-center gap-2">
                      <ButtonLink
                        href={`/dashboard/objetivos/${goal.id}/editar`}
                        text="Editar"
                        color=" bg-yellow-500 text-white"
                        hoverColor="hover:bg-yellow-700"
                      />
                      <button
                        onClick={() => handleDelete(goal.id)}
                        className="bg-red-500 text-white px-3 py-1 rounded hover:bg-red-700"
                      >
                        Excluir
                      </button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </main>
  );
}
