import { Component, OnInit } from '@angular/core';
import {HttpClient, HttpClientModule} from '@angular/common/http';
import { Product } from './product.model';
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true, // Add this line for standalone component
  imports: [HttpClientModule, NgForOf, NgIf], // Import HttpClientModule here
})
export class AppComponent implements OnInit {
  title = 'front-app-ui';
  products: Product[] = [];

  private apiUrl = 'http://localhost:8088/api/products'; // Replace with your API endpoint

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    this.http.get<Product[]>(this.apiUrl).subscribe(
      (data: Product[]) => {
        this.products = data;
      },
      (error) => {
        console.error('There was an error!', error);
      }
    );
  }
}
