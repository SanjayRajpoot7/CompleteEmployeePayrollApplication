import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-employee-payroll',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee-payroll.component.html',
  styleUrls: ['./employee-payroll.component.css']
})
export class EmployeePayrollComponent {
  employees: any[] = []; // Ensure this array exists

  newEmployee = { name: '', gender: '', department: '', salary: '', startDate: '' };

  addEmployee() {
    if (this.newEmployee.name && this.newEmployee.salary && this.newEmployee.startDate) {
      this.employees.push({
        id: this.employees.length + 1, // Assign ID dynamically
        ...this.newEmployee
      });

      // Clear the form after submission
      this.newEmployee = { name: '', gender: '', department: '', salary: '', startDate: '' };
    }
  }

  removeEmployee(id: number) {
    this.employees = this.employees.filter(emp => emp.id !== id);
  }
}
