"use client";

import ButtonLink from "@/components/ButtonLink";
import { Income } from "@/interfaces/income.interface";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function DashboardIncomePage() {
  const [incomes, setIncomes] = useState<Income[]>([]);
  const [loading, setLoading] = useState(true);
  const router = useRouter();

  useEffect(() => {
    const token = localStorage.getItem("user_token");
    if (!token) {
      router.push("/login");
      return;
    }

    async function fetchIncomes() {
      try {
        const response = await fetch("/api/dashboard/incomes");
        if (!response.ok) {
          throw new Error("Erro na resposta da API");
        }
        const data = await response.json();
        setIncomes(data);
      } catch (error) {
        console.error("Erro ao buscar receitas:", error);
      } finally {
        setLoading(false);
      }
    }

    fetchIncomes();
  }, [router]);

  const handleDelete = async (id: number) => {
    if (!confirm("Deseja  realmente  excluir  esta receita?")) return;

    const res = await fetch(`/api/dashboard/incomes/${id}`, {
      method: "DELETE",
    });
    if (res.ok) {
      setIncomes((prev) => prev.filter((e) => e.id !== id));
    } else {
      alert("Falha ao excluir a receita.");
    }
  };

  return (
    <main className="container mx-auto p-6">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold">Receitas</h1>
        <ButtonLink
          href="/dashboard/receitas/novo"
          text="Nova Receita"
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
                <th className="px-6 py-3 border-b">Descrição</th>
                <th className="px-6 py-3 border-b">Valor</th>
                <th className="px-6 py-3 border-b">Status</th>
                <th className="px-6 py-3 border-b">Data de Vencimento</th>
                <th className="px-6 py-3 border-b">Data de Pagamento</th>
                <th className="px-6 py-3 border-b">Id Categoria</th>
                <th className="px-6 py-3 border-b">Ações</th>
              </tr>
            </thead>
            <tbody>
              {incomes.length === 0 && (
                <tr>
                  <td colSpan={7} className="px-6 py-4 text-center">
                    Nenhuma receita encontrada.
                  </td>
                </tr>
              )}
              {incomes.map((income) => (
                <tr key={income.id}>
                  <td className="px-6 py-4 border-b">{income.id}</td>
                  <td className="px-6 py-4 border-b">{income.description}</td>
                  <td className="px-6 py-4 border-b">
                    R${" "}
                    {income.value.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    })}
                  </td>
                  <td className="px-6 py-4 border-b">{income.status}</td>
                  <td className="px-6 py-4 border-b">
                    {income.dueDate
                      ? new Date(income.dueDate).toLocaleDateString()
                      : "-"}
                  </td>
                  <td className="px-6 py-4 border-b">
                    {income.paymentDate
                      ? new Date(income.paymentDate).toLocaleDateString()
                      : "-"}
                  </td>
                  <td className="px-6 py-4 border-b">{income.categoryId}</td>
                  <td className="px-6 py-4 border-b">
                    <div className="flex justify-center gap-2">
                      <ButtonLink
                        href={`/dashboard/receitas/${income.id}/editar`}
                        text="Editar"
                        color=" bg-yellow-500 text-white"
                        hoverColor="hover:bg-yellow-700"
                      />
                      <button
                        onClick={() => handleDelete(income.id)}
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
