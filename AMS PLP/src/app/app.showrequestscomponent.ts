import {Component, OnInit} from '@angular/core';
import {AssetManagementService} from './_service/app.assetmanagementservice';
import {Assets} from './_model/app.assets';
import {Router} from '@angular/router';
import { AllocationRequest } from './_model/app.allocationRequest';

@Component({
    selector: 'showrequests',
    templateUrl: 'app.showrequests.html'
})

export class ShowRequestsComponent implements OnInit{
    asset:Assets;
    
    allocationRequest:AllocationRequest[]=[];
    constructor(private service:AssetManagementService, private router:Router){}

    ngOnInit(){
        this.service.showRequests().subscribe((data:AllocationRequest[])=>
            this.allocationRequest=data);
    }

    approveRequest(allocationId: number):any{
        this.service.approveRequest(allocationId).subscribe();
        location.reload();
    }

    rejectRequest(allocationId: number):any{
        this.service.rejectRequest(allocationId).subscribe();
        location.reload();
    }
}

