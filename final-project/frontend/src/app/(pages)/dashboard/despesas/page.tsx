"use client";

import ButtonLink from "@/components/ButtonLink";
import { Expense } from "@/interfaces/expense.interface";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function DashboardExpensePage() {
  const [expenses, setExpenses] = useState<Expense[]>([]);
  const [loading, setLoading] = useState(true);
  const router = useRouter();

  useEffect(() => {
    const token = localStorage.getItem("user_token");
    if (!token) {
      router.push("/login");
      return;
    }

    async function fetchExpenses() {
      try {
        const response = await fetch("/api/dashboard/expenses");
        if (!response.ok) {
          throw new Error("Erro na resposta da API");
        }
        const data = await response.json();
        setExpenses(data);
      } catch (error) {
        console.error("Erro ao buscar despesas:", error);
      } finally {
        setLoading(false);
      }
    }

    fetchExpenses();
  }, [router]);

  const handleDelete = async (id: number) => {
    if (!confirm("Deseja  realmente  excluir  esta despesa?")) return;

    const res = await fetch(`/api/dashboard/expenses/${id}`, {
      method: "DELETE",
    });
    if (res.ok) {
      setExpenses((prev) => prev.filter((e) => e.id !== id));
    } else {
      alert("Falha ao excluir a despesa.");
    }
  };

  return (
    <main className="container mx-auto p-6">
      <div className="flex justify-between items-center mb-6">
        <h1 className="text-2xl font-bold">Despesas</h1>
        <ButtonLink
          href="/dashboard/despesas/novo"
          text="Nova Despesa"
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
              {expenses.length === 0 && (
                <tr>
                  <td colSpan={7} className="px-6 py-4 text-center">
                    Nenhuma despesa encontrada.
                  </td>
                </tr>
              )}
              {expenses.map((expense) => (
                <tr key={expense.id}>
                  <td className="px-6 py-4 border-b">{expense.id}</td>
                  <td className="px-6 py-4 border-b">{expense.description}</td>
                  <td className="px-6 py-4 border-b">
                    R${" "}
                    {expense.value.toLocaleString("pt-BR", {
                      minimumFractionDigits: 2,
                    })}
                  </td>
                  <td className="px-6 py-4 border-b">{expense.status}</td>
                  <td className="px-6 py-4 border-b">
                    {expense.dueDate
                      ? new Date(expense.dueDate).toLocaleDateString()
                      : "-"}
                  </td>
                  <td className="px-6 py-4 border-b">
                    {expense.paymentDate
                      ? new Date(expense.paymentDate).toLocaleDateString()
                      : "-"}
                  </td>
                  <td className="px-6 py-4 border-b">{expense.categoryId}</td>
                  <td className="px-6 py-4 border-b">
                    <div className="flex justify-center gap-2">
                      <ButtonLink
                        href="/dashboard/expenses/${expense.id}/edit"
                        text="Editar"
                        color=" bg-yellow-500 text-white"
                        hoverColor="hover:bg-yellow-700"
                      />
                      <button
                        onClick={() => handleDelete(expense.id)}
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
