import {Component, OnInit} from '@angular/core';
import {AssetManagementService} from './_service/app.assetmanagementservice';
import {Assets} from './_model/app.assets';
import {Router} from '@angular/router';


@Component({
    selector: 'show',
    templateUrl: 'app.showassets.html'
})

export class ShowAssetsComponent implements OnInit{

    

    asset:Assets[]=[];
    constructor(private service:AssetManagementService, private router:Router){}       

    
    ngOnInit(){
        this.service.showAssets().subscribe((data:Assets[])=>
            this.asset=data);
    }

    deleteAsset(assetId: number):any{
        this.service.deleteAsset(assetId).subscribe();
        location.reload();
    }

}