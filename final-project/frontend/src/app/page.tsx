import ButtonLink from "@/components/ButtonLink";

export default function Home() {
  return (
    <main className="flex flex-col items-center justify-center min-h-screen py-2">
      <h1 className="text-xl font-bold my-2">Seja bem-vindo ao Fintech</h1>

      <p className="text-base my-2">
        {" "}
        Toda a sua vida financeira na palma da sua mão{" "}
      </p>

      <div className="flex gap-4 justify-center mt-4">
        <ButtonLink href="/login" text="Login" />
        <ButtonLink
          href="/cadastrar"
          text="Cadastrar"
          color="bg-white-500 text-gray-800"
          hoverColor="hover:bg-gray-500"
        />
      </div>
    </main>
  );
}
