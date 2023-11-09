import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject, Observable} from 'rxjs';

import { RoleService } from 'src/app/zynerator/security/Role.service';
import {environment} from 'src/environments/environment';

import {InstrumentDto} from 'src/app/controller/model/chequeffet/Instrument.model';
import {InstrumentCriteria} from 'src/app/controller/criteria/chequeffet/InstrumentCriteria.model';
import {AbstractService} from 'src/app/zynerator/service/AbstractService';


@Injectable({
  providedIn: 'root'
})
export class InstrumentAdminService extends AbstractService<InstrumentDto, InstrumentCriteria> {
     constructor(private http: HttpClient, private roleService: RoleService) {
        super();
        this.setHttp(http);
        this.setApi(environment.apiUrl + 'admin/instrument/');
    }

    public constrcutDto(): InstrumentDto {
        return new InstrumentDto();
    }

    public constrcutCriteria(): InstrumentCriteria {
        return new InstrumentCriteria();
    }
}
