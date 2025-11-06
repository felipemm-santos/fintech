import { NextResponse } from "next/server";

export async function POST(request: Request) {
  const body = await request.json();
  const { email, password } = body;

  // Simulação de autenticação
  if (email === "teste@exemplo.com" && password === "teste123") {
    // Retorna um token fictício
    return NextResponse.json({ token: "fake-user-token" });
  }
  return NextResponse.json(
    { message: "Credenciais inválidas" },
    { status: 401 }
  );
}
