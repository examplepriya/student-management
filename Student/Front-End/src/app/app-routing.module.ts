import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateStudentComponent } from './create-student/create-student.component';
import { HomeComponent } from './home/home.component';
import { StudentComponent } from './student/student.component';
import { UpdateStudentComponent } from './update-student/update-student.component';

const routes: Routes = [
  {path:"home",component:HomeComponent},
  {path:"student",component:StudentComponent},
  {path:"create-student",component:CreateStudentComponent},
  {path:"update-student/:id",component:UpdateStudentComponent},
  {path:"",redirectTo:"home",pathMatch:"full"}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
