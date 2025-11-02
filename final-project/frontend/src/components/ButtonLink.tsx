"use client";

import Link from "next/link";

interface ButtonLinkProps {
  href: string;
  text: string;
  color?: string; // opcional — padrão azul
  hoverColor?: string;
}

export default function ButtonLink({
  href,
  text,
  color = "bg-blue-500 text-white",
  hoverColor = "hover:bg-blue-700",
}: ButtonLinkProps) {
  return (
    <Link
      href={href}
      className={`${color} ${hoverColor} py-2 px-4 rounded transition-colors duration-200 border border-black-500 inline-block text-center`}
    >
      {text}
    </Link>
  );
}
