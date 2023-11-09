import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {TauxTvaDto} from 'src/app/controller/model/stock/TauxTva.model';
import {TauxTvaCriteria} from 'src/app/controller/criteria/stock/TauxTvaCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class TauxTvaAdminService extends AbstractService<TauxTvaDto, TauxTvaCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/tauxTva/');
    }

    public constrcutDto(): TauxTvaDto {
        return new TauxTvaDto();
    }

    public constrcutCriteria(): TauxTvaCriteria {
        return new TauxTvaCriteria();
    }
}
