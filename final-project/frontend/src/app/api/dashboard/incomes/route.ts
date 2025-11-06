import { NextResponse } from "next/server";

export async function GET() {
  try {
    const response = await fetch(`${process.env.API_URL}/api/income`);
    const data = await response.json();
    return NextResponse.json(data);
  } catch (error) {
    console.error("Erro ao buscar receitas:", error);
    return NextResponse.json(
      { message: "Erro ao buscar receitas" },
      { status: 500 }
    );
  }
}

export async function POST(request: Request) {
  try {
    const body = await request.json();
    const response = await fetch(`${process.env.API_URL}/api/income`, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(body),
    });
    const data = await response.json();
    return NextResponse.json(data);
  } catch (error) {
    console.error("Erro ao criar receita:", error);
    return NextResponse.json(
      { message: "Erro ao criar receita" },
      { status: 500 }
    );
  }
}
