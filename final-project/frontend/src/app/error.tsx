"use client";

export default function ErrorPage() {
  return (
    <div className="flex flex-col items-center justify-center h-full">
      <h1 className="text-4xl font-bold mb-4">
        500 - Erro Interno do Servidor
      </h1>
      <p className="text-lg text-gray-600">
        Desculpe, algo deu errado no nosso servidor.
      </p>
    </div>
  );
}
