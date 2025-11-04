"use client";

import { Expense } from "@/interfaces/expense.interface";
import { useRouter } from "next/navigation";
import { useEffect, useState } from "react";

export default function DashboardPage() {
  const [produtos, setExpenses] = useState<Expense[]>([]);
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
        const response = await fetch("/api/expense");
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
    if (!confirm("Deseja  realmente  excluir  este  produto?")) return;

    const res = await fetch(`/api/dashboard/expenses/${id}`, {
      method: "DELETE",
    });
    if (res.ok) {
      setExpenses((prev) => prev.filter((e) => e.id !== id));
    } else {
      alert("Falha ao excluir o produto");
    }
  };

  return (
    <main className="container mx-auto p-6">
      <h1 className="text-2xl font-bold mb-6">Despesas</h1>
    </main>
  );
}
