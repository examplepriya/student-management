import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../student'; 
import { StudentService } from '../student.service';

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  students: Student[];

  constructor(private studentService:StudentService,
    private router:Router){ }
      ngOnInit():void{
        this.getAllStudents();
      }
      getAllStudents(){
        this.studentService.getAllStudent().subscribe(data=>{
          this.students=data;
        });
      }
      updateStudent(id:number){
        this.router.navigate(['update-student',id]);
      }
      deleteStudent(id:number){
        this.studentService.deleteStudent(id).subscribe(data=>{
          console.log(data);
          this.getAllStudents();
        })
      }
  }



