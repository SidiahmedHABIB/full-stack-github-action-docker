export interface Category {
  id: string | null;
  name: string | null;
  description: string | null;
}

export interface Product {
  id: string;
  name: string;
  description: string;
  tags: string[] | null;
  category: Category | null;
}
