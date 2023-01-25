import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { StudentComponent } from './student/student.component';
import { HttpClientModule} from '@angular/common/http';
import { CreateStudentComponent } from './create-student/create-student.component';
import { FormsModule } from '@angular/forms';
import { UpdateStudentComponent } from './update-student/update-student.component';
import { HomeComponent } from './home/home.component';
@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    CreateStudentComponent,
    UpdateStudentComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
