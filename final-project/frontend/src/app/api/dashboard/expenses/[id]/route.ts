import { NextResponse } from "next/server";

export async function GET(
  request: Request,
  props: { params: Promise<{ id: string }> }
) {
  const params = await props.params;
  try {
    const response = await fetch(
      `${process.env.API_URL}/api/expense/${params.id}`
    );
    const data = await response.json();
    return NextResponse.json(data);
  } catch (error) {
    console.error("Erro ao buscar despesa:", error);
    return NextResponse.json(
      { message: "Erro ao buscar despesa" },
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
      `${process.env.API_URL}/api/expense/${params.id}`,
      {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(body),
      }
    );
    const data = await response.json();
    return NextResponse.json(data);
  } catch (error) {
    console.error("Erro ao atualizar despesa:", error);
    return NextResponse.json(
      { message: "Erro ao atualizar despesa" },
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
      `${process.env.API_URL}/api/expense/${params.id}`,
      { method: "DELETE" }
    );

    if (!response.ok) {
      const text = await response.text();
      return NextResponse.json(
        { message: text || "Erro ao excluir" },
        { status: response.status }
      );
    }

    return NextResponse.json({ message: "Despesa excluída" }, { status: 200 });
  } catch (error: unknown) {
    console.error("Erro ao excluir despesa:", error);
    return NextResponse.json({ message: "Erro interno" }, { status: 500 });
  }
}
