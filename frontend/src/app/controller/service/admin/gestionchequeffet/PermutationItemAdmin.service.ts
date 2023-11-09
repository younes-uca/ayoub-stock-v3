import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {PermutationItemDto} from 'src/app/controller/model/gestionchequeffet/PermutationItem.model';
import {PermutationItemCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationItemCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PermutationItemAdminService extends AbstractService<PermutationItemDto, PermutationItemCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/permutationItem/');
    }

    public constrcutDto(): PermutationItemDto {
        return new PermutationItemDto();
    }

    public constrcutCriteria(): PermutationItemCriteria {
        return new PermutationItemCriteria();
    }
}
