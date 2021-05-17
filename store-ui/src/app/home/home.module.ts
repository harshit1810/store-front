import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpService} from '../common/services/http.service'


@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [HttpService],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class HomeModule { }
