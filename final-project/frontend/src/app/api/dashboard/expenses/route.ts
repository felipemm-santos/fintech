import { NextResponse } from "next/server";
export async function GET() {
  try {
    const response = await fetch(`${process.env.API_URL}/api/expense`);
    const data = await response.json();
    return NextResponse.json(data);
  } catch (error) {
    console.error("Erro ao buscar despesas:", error);
    return NextResponse.json(
      { message: "Erro ao buscar despesas" },
      { status: 500 }
    );
  }
}