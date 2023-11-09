import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {PaiementAvoirVenteDto} from 'src/app/controller/model/paiement/PaiementAvoirVente.model';
import {PaiementAvoirVenteCriteria} from 'src/app/controller/criteria/paiement/PaiementAvoirVenteCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class PaiementAvoirVenteAdminService extends AbstractService<PaiementAvoirVenteDto, PaiementAvoirVenteCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/paiementAvoirVente/');
    }

    public constrcutDto(): PaiementAvoirVenteDto {
        return new PaiementAvoirVenteDto();
    }

    public constrcutCriteria(): PaiementAvoirVenteCriteria {
        return new PaiementAvoirVenteCriteria();
    }
}
