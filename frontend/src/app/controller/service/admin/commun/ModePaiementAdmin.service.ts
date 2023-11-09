import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {ModePaiementDto} from 'src/app/controller/model/commun/ModePaiement.model';
import {ModePaiementCriteria} from 'src/app/controller/criteria/commun/ModePaiementCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class ModePaiementAdminService extends AbstractService<ModePaiementDto, ModePaiementCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/modePaiement/');
    }

    public constrcutDto(): ModePaiementDto {
        return new ModePaiementDto();
    }

    public constrcutCriteria(): ModePaiementCriteria {
        return new ModePaiementCriteria();
    }
}
