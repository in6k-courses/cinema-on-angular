import {RouterModule, Routes} from "@angular/router";
import {NgModule} from "@angular/core";

import {GenreComponent} from "./genre/genre.component";
import {MovieComponent} from "./movie/movie.component";
import {CommComponent} from "./comm/comm.component";
import {DescrComponent} from "./descr/descr.component";
import {AddNewMovieComponent} from "./add-new-movie/add-new-movie.component";
import {AddNewGenreComponent} from "./add-new-genre/add-new-genre.component";
const routes: Routes = [
  {path: '', redirectTo: '/genre', pathMatch: 'full'},
  {path: 'movies', component: MovieComponent},
  {path: 'genre', component: GenreComponent},
  {path: 'details/:id', component: DescrComponent},
  {path: 'newMovie', component: AddNewMovieComponent},
  {path: 'newGenre', component: AddNewGenreComponent},
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
