import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {PaiementVenteDto} from 'src/app/controller/model/paiement/PaiementVente.model';
import {PaiementVenteCriteria} from 'src/app/controller/criteria/paiement/PaiementVenteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PaiementVenteAdminService extends AbstractService<PaiementVenteDto, PaiementVenteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paiementVente/');
    }

    public constrcutDto(): PaiementVenteDto {
        return new PaiementVenteDto();
    }

    public constrcutCriteria(): PaiementVenteCriteria {
        return new PaiementVenteCriteria();
    }
}
