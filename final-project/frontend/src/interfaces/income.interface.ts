export interface Income {
  id: number;
  userId: number;
  categoryId: number;
  description: string;
  value: number;
  status: string;
  dueDate: Date;
  paymentDate: Date;
  createdAt: Date;
}
