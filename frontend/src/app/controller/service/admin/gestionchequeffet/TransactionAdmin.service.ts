import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {TransactionDto} from 'src/app/controller/model/gestionchequeffet/Transaction.model';
import {TransactionCriteria} from 'src/app/controller/criteria/gestionchequeffet/TransactionCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TransactionAdminService extends AbstractService<TransactionDto, TransactionCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/transaction/');
    }

    public constrcutDto(): TransactionDto {
        return new TransactionDto();
    }

    public constrcutCriteria(): TransactionCriteria {
        return new TransactionCriteria();
    }
}
