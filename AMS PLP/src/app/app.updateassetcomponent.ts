import {Component, OnInit} from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Assets } from './_model/app.assets';
import {AssetManagementService} from './_service/app.assetmanagementservice'

@Component({
    selector: 'modify',
    templateUrl: 'app.modifyasset.html'
})

export class UpdateAssetComponent implements OnInit{
    show:boolean=false;
    updateId:any;
    currAsset:Assets={"assetId": 0, "assetName": "", "quantity":200};

    constructor(private route: ActivatedRoute, private service:AssetManagementService){}

    ngOnInit(){
        this.currAsset=new Assets();
    }
    searchAsset(assetId:number):any{
        this.service.searchAsset(assetId).subscribe((asset: Assets)=>this.currAsset=asset);
        this.show=true;
    
    }

    updateAsset(){
        this.service.updateAsset(this.currAsset).subscribe();
    }

}