import {Component} from '@angular/core';
import { AssetManagementService } from './_service/app.assetmanagementservice';
import { Assets } from './_model/app.assets';
import { Router } from '@angular/router';

@Component({
    selector: 'search',
    templateUrl: 'app.searchasset.html'
})

export class SearchAssetComponent{
    
    assetId:number;
    asset:Assets;
    show:boolean=false;

    ngOnInit(){
    this.asset=new Assets();    }

    constructor(private router:Router ,private service:AssetManagementService){}

    searchAsset(assetId:number):any{
        this.service.searchAsset(assetId).subscribe((asset: Assets)=>this.asset=asset);
        this.show=true;
    
    }
    idValid:boolean=false;
    validateId(){
        if(this.asset.assetId>999){
            this.idValid=true;
        }
        else if(this.asset.assetId<1){
            this.idValid=true;
        }else{
            this.idValid=false;
        }
    }

}