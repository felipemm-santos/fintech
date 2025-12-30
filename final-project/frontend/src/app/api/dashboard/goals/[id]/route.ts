import { NextResponse } from "next/server";

export async function GET(
  request: Request,
  props: { params: Promise<{ id: string }> }
) {
  const params = await props.params;
  try {
    const response = await fetch(
      `${process.env.API_URL}/api/goal/${params.id}`
    );
    const data = await response.json();
    return NextResponse.json(data);
  } catch (error) {
    console.error("Erro ao buscar objetivo:", error);
    return NextResponse.json(
      { message: "Erro ao buscar objetivo" },
      { status: 500 }
    );
  }
}

export async function PUT(
  request: Request,
  props: { params: Promise<{ id: string }> }
) {
  const params = await props.params;
  try {
    const body = await request.json();
    const response = await fetch(
      `${process.env.API_URL}/api/goal/${params.id}`,
      {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body),
      }
    );
    const data = await response.json();
    return NextResponse.json(data);
  } catch (error) {
    console.error("Erro ao atualizar objetivo:", error);
    return NextResponse.json(
      { message: "Erro ao atualizar objetivo" },
      { status: 500 }
    );
  }
}

export async function DELETE(
  request: Request,
  props: { params: Promise<{ id: string }> }
) {
  const params = await props.params;
  try {
    const response = await fetch(
      `${process.env.API_URL}/api/goal/${params.id}`,
      { method: "DELETE" }
    );

    if (!response.ok) {
      const text = await response.text();
      return NextResponse.json(
        { message: text || "Erro ao excluir" },
        { status: response.status }
      );
    }

    return NextResponse.json({ message: "Objetivo excluído" }, { status: 200 });
  } catch (error: unknown) {
    console.error("Erro ao excluir objetivo:", error);
    return NextResponse.json({ message: "Erro interno" }, { status: 500 });
  }
}
