import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {PermutationDto} from 'src/app/controller/model/gestionchequeffet/Permutation.model';
import {PermutationCriteria} from 'src/app/controller/criteria/gestionchequeffet/PermutationCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PermutationAdminService extends AbstractService<PermutationDto, PermutationCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/permutation/');
    }

    public constrcutDto(): PermutationDto {
        return new PermutationDto();
    }

    public constrcutCriteria(): PermutationCriteria {
        return new PermutationCriteria();
    }
}
