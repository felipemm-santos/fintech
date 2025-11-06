"use client";

import { useState } from "react";

interface DropdownOption {
  id: string;
  label: string;
  options: { value: string; label: string }[];
  divClassName?: string;
  labelClassName?: string;
  selectClassName?: string;
  onChange: (value: string) => void;
}

export default function Select({
  id,
  label,
  options,
  onChange,
  divClassName,
  labelClassName,
  selectClassName,
}: DropdownOption) {
  const [selectedValue, setSelectedValue] = useState("");

  const handleChange = (event: React.ChangeEvent<HTMLSelectElement>) => {
    setSelectedValue(event.target.value);
    onChange(event.target.value);
  };

  return (
    <div className={divClassName}>
      <label htmlFor={id} className={labelClassName}>
        {label}
      </label>
      <select
        id={id}
        value={selectedValue}
        onChange={handleChange}
        className={selectClassName}
      >
        {options.map((option) => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </select>
    </div>
  );
}
