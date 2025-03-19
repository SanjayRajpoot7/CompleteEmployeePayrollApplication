import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeePayrollComponent } from './employee-payroll/employee-payroll.component';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule, EmployeePayrollComponent],
// imports: [CommonModule, FormsModule, EmployeePayrollComponent]

  template: `
    <h1 class="title">Welcome to Employee Payroll System</h1>
    <app-employee-payroll></app-employee-payroll>
  `,
  styles: [`
    .title {
      text-align: center;
      font-size: 30px;
      font-weight: bold;
      margin: 20px 0;
      color:rgb(33, 34, 47); /* Dark Green */
      text-transform: uppercase;
    }
  `]
})
export class AppComponent {}
