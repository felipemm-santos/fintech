export interface Goal {
  id: number;
  userId: number;
  name: string;
  targetAmount: number;
  currentAmount: number;
  targetDate: Date;
  status: number;
  description: string;
  completionDate: Date;
  createdAt: Date;
}
