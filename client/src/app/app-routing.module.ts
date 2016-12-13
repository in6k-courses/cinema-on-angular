import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";

import {GenreComponent} from "./genre/genre.component";
import {MovieComponent} from "./movie/movie.component";
import {CommComponent} from "./comm/comm.component";
import {DescrComponent} from "./descr/descr.component";

const routes: Routes = [
  {path: '', redirectTo: '/genre', pathMatch: 'full'},
  {path: 'movies', component: MovieComponent},
  {path: 'genre', component: GenreComponent},
  {path: 'details/:id', component: DescrComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
