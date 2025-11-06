import Link from "next/link";

export default function Header() {
  return (
    <header className="bg-white shadow p-4">
      <div className="container mx-auto flex items-center justify-evenly">
        <Link href="/dashboard/expenses" className="font-bold text-2xl">
          Fintech
        </Link>
        <nav className="flex items-center gap-4">
          <Link href="/dashboard/despesas">Despesas</Link>
          <Link href="/dashboard/receitas">Receitas</Link>
          <Link href="/dashboard/objetivos">Objetivos</Link>
        </nav>
      </div>
    </header>
  );
}
