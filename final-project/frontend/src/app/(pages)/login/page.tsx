"use client";
import { useRouter } from "next/navigation";
import { useState } from "react";

export default function LoginPage() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState<string | null>(null);
  const router = useRouter();

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setError(null);
    try {
      const res = await fetch("/api/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ email, password }),
      });
      if (!res.ok) {
        const body = await res.json();
        throw new Error(body.message || "Falha na autenticação");
      }
      const data = await res.json();
      localStorage.setItem("user_token", data.token);
      router.push("/dashboard/expenses");
    } catch (err: unknown) {
      setError((err as Error).message);
    }
  };

  return (
    <main className="mx-auto p-8 mt-8 flex flex-col items-center justify-center w-72  border border-gray-300 rounded-lg shadow-lg ">
      <h1 className="text-center font-bold text-gray-600">Login</h1>
      
      <form onSubmit={handleSubmit} className="flex flex-col gap-4 mt-4 ">
        {error && <p className="text-red-600">{error}</p>}
        <div>
          <label htmlFor="email" className="block font-medium mb-1'">
            Email:
          </label>
          <input
            type="email"
            id="email"
            name="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
            className="font-medium border border-gray-300 rounded-lg px-2 py-1 w-full focus:outline-none focus:ring-blue-500"
          />
        </div>

        <div>
          <label htmlFor="password" className="block font-medium mb-1">
            Senha:
          </label>
          <input
            type="password"
            id="password"
            name="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
            className="font-medium border border-gray-300 rounded-lg px-2 py-1 w-full focus:outline-none focus:ring-blue-500"
          />
        </div>

        <button
          type="submit"
          className="bg-blue-500 text-white font-medium py-2 px-4 rounded hover:bg-blue-600 transition-colors duration-200 mt-2"
        >
          Entrar
        </button>
      </form>
    </main>
  );
}
