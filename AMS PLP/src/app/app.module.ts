import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { FormsModule } from "@angular/forms";
import { AddAssetComponent } from "./app.addassetcomponent";
import { HttpClientModule } from '@angular/common/http'
import { ShowAssetsComponent } from './app.showassetscomponent';
import { AboutUsComponent } from './app.aboutuscomponent';
import { Routes, RouterModule } from '@angular/router';
import { SearchAssetComponent } from './app.searchassetcomponent';
import { UpdateAssetComponent } from './app.updateassetcomponent';
import { AddRequest } from './app.addrequest';
import { ShowRequestsComponent} from './app.showrequestscomponent';

//{path: 'show/:text', component: ShowComponent},
const myroutes:Routes= [
    {path: '', redirectTo:'about', pathMatch: 'full'},
    {path: 'about', component: AboutUsComponent},
    {path: 'add', component: AddAssetComponent},
    {path: 'show', component: ShowAssetsComponent},
    {path: 'search', component: SearchAssetComponent},
    {path: 'modify', component: UpdateAssetComponent},
    {path: 'addRequest', component:AddRequest},
    {path: 'showRequests', component: ShowRequestsComponent}
];

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        RouterModule.forRoot(myroutes)
    ],
    declarations: [
        AppComponent,
        AddAssetComponent,
        ShowAssetsComponent,
        AboutUsComponent,
        SearchAssetComponent,
        UpdateAssetComponent,
        AddRequest,
        ShowRequestsComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }