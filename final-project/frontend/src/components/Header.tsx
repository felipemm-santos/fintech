import Link from "next/link";

export default function Header() {
  return (
    <header className="bg-white shadow p-4">
      <div className="container mx-auto flex items-center justify-evenly">
        <Link href="/dashboard/expenses" className="font-bold text-2xl">
          Fintech
        </Link>
        <nav className="flex items-center gap-4">
          <Link href="/dashboard/expenses">Despesas</Link>
          <Link href="/dashboard/incomes">Receitas</Link>
          <Link href="/dashboard/investiments">Investimentos</Link>
          <Link href="/dashboard/goals">Objetivos</Link>
        </nav>
      </div>
    </header>
  );
}
