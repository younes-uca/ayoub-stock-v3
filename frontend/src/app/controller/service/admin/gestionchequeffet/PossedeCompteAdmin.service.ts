import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {PossedeCompteDto} from 'src/app/controller/model/gestionchequeffet/PossedeCompte.model';
import {PossedeCompteCriteria} from 'src/app/controller/criteria/gestionchequeffet/PossedeCompteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PossedeCompteAdminService extends AbstractService<PossedeCompteDto, PossedeCompteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/possedeCompte/');
    }

    public constrcutDto(): PossedeCompteDto {
        return new PossedeCompteDto();
    }

    public constrcutCriteria(): PossedeCompteCriteria {
        return new PossedeCompteCriteria();
    }
}
