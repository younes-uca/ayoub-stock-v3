import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';

import { ProprietaireCreateAdminComponent } from './proprietaire/create/proprietaire-create-admin.component';
import { ProprietaireEditAdminComponent } from './proprietaire/edit/proprietaire-edit-admin.component';
import { ProprietaireViewAdminComponent } from './proprietaire/view/proprietaire-view-admin.component';
import { ProprietaireListAdminComponent } from './proprietaire/list/proprietaire-list-admin.component';
import { ProprietaireBanqueCreateAdminComponent } from './proprietaire-banque/create/proprietaire-banque-create-admin.component';
import { ProprietaireBanqueEditAdminComponent } from './proprietaire-banque/edit/proprietaire-banque-edit-admin.component';
import { ProprietaireBanqueViewAdminComponent } from './proprietaire-banque/view/proprietaire-banque-view-admin.component';
import { ProprietaireBanqueListAdminComponent } from './proprietaire-banque/list/proprietaire-banque-list-admin.component';
import { TransactionCreateAdminComponent } from './transaction/create/transaction-create-admin.component';
import { TransactionEditAdminComponent } from './transaction/edit/transaction-edit-admin.component';
import { TransactionViewAdminComponent } from './transaction/view/transaction-view-admin.component';
import { TransactionListAdminComponent } from './transaction/list/transaction-list-admin.component';
import { TypeTransactionCreateAdminComponent } from './type-transaction/create/type-transaction-create-admin.component';
import { TypeTransactionEditAdminComponent } from './type-transaction/edit/type-transaction-edit-admin.component';
import { TypeTransactionViewAdminComponent } from './type-transaction/view/type-transaction-view-admin.component';
import { TypeTransactionListAdminComponent } from './type-transaction/list/type-transaction-list-admin.component';
import { CompteCreateAdminComponent } from './compte/create/compte-create-admin.component';
import { CompteEditAdminComponent } from './compte/edit/compte-edit-admin.component';
import { CompteViewAdminComponent } from './compte/view/compte-view-admin.component';
import { CompteListAdminComponent } from './compte/list/compte-list-admin.component';
import { ChequeEffetCreateAdminComponent } from './cheque-effet/create/cheque-effet-create-admin.component';
import { ChequeEffetEditAdminComponent } from './cheque-effet/edit/cheque-effet-edit-admin.component';
import { ChequeEffetViewAdminComponent } from './cheque-effet/view/cheque-effet-view-admin.component';
import { ChequeEffetListAdminComponent } from './cheque-effet/list/cheque-effet-list-admin.component';
import { PermutationCreateAdminComponent } from './permutation/create/permutation-create-admin.component';
import { PermutationEditAdminComponent } from './permutation/edit/permutation-edit-admin.component';
import { PermutationViewAdminComponent } from './permutation/view/permutation-view-admin.component';
import { PermutationListAdminComponent } from './permutation/list/permutation-list-admin.component';
import { PossedeCompteCreateAdminComponent } from './possede-compte/create/possede-compte-create-admin.component';
import { PossedeCompteEditAdminComponent } from './possede-compte/edit/possede-compte-edit-admin.component';
import { PossedeCompteViewAdminComponent } from './possede-compte/view/possede-compte-view-admin.component';
import { PossedeCompteListAdminComponent } from './possede-compte/list/possede-compte-list-admin.component';
import { PermutationItemCreateAdminComponent } from './permutation-item/create/permutation-item-create-admin.component';
import { PermutationItemEditAdminComponent } from './permutation-item/edit/permutation-item-edit-admin.component';
import { PermutationItemViewAdminComponent } from './permutation-item/view/permutation-item-view-admin.component';
import { PermutationItemListAdminComponent } from './permutation-item/list/permutation-item-list-admin.component';
import { TypeInstrumentCreateAdminComponent } from './type-instrument/create/type-instrument-create-admin.component';
import { TypeInstrumentEditAdminComponent } from './type-instrument/edit/type-instrument-edit-admin.component';
import { TypeInstrumentViewAdminComponent } from './type-instrument/view/type-instrument-view-admin.component';
import { TypeInstrumentListAdminComponent } from './type-instrument/list/type-instrument-list-admin.component';
import { BanqueCreateAdminComponent } from './banque/create/banque-create-admin.component';
import { BanqueEditAdminComponent } from './banque/edit/banque-edit-admin.component';
import { BanqueViewAdminComponent } from './banque/view/banque-view-admin.component';
import { BanqueListAdminComponent } from './banque/list/banque-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    ProprietaireCreateAdminComponent,
    ProprietaireListAdminComponent,
    ProprietaireViewAdminComponent,
    ProprietaireEditAdminComponent,
    ProprietaireBanqueCreateAdminComponent,
    ProprietaireBanqueListAdminComponent,
    ProprietaireBanqueViewAdminComponent,
    ProprietaireBanqueEditAdminComponent,
    TransactionCreateAdminComponent,
    TransactionListAdminComponent,
    TransactionViewAdminComponent,
    TransactionEditAdminComponent,
    TypeTransactionCreateAdminComponent,
    TypeTransactionListAdminComponent,
    TypeTransactionViewAdminComponent,
    TypeTransactionEditAdminComponent,
    CompteCreateAdminComponent,
    CompteListAdminComponent,
    CompteViewAdminComponent,
    CompteEditAdminComponent,
    ChequeEffetCreateAdminComponent,
    ChequeEffetListAdminComponent,
    ChequeEffetViewAdminComponent,
    ChequeEffetEditAdminComponent,
    PermutationCreateAdminComponent,
    PermutationListAdminComponent,
    PermutationViewAdminComponent,
    PermutationEditAdminComponent,
    PossedeCompteCreateAdminComponent,
    PossedeCompteListAdminComponent,
    PossedeCompteViewAdminComponent,
    PossedeCompteEditAdminComponent,
    PermutationItemCreateAdminComponent,
    PermutationItemListAdminComponent,
    PermutationItemViewAdminComponent,
    PermutationItemEditAdminComponent,
    TypeInstrumentCreateAdminComponent,
    TypeInstrumentListAdminComponent,
    TypeInstrumentViewAdminComponent,
    TypeInstrumentEditAdminComponent,
    BanqueCreateAdminComponent,
    BanqueListAdminComponent,
    BanqueViewAdminComponent,
    BanqueEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,

  ],
  exports: [
  ProprietaireCreateAdminComponent,
  ProprietaireListAdminComponent,
  ProprietaireViewAdminComponent,
  ProprietaireEditAdminComponent,
  ProprietaireBanqueCreateAdminComponent,
  ProprietaireBanqueListAdminComponent,
  ProprietaireBanqueViewAdminComponent,
  ProprietaireBanqueEditAdminComponent,
  TransactionCreateAdminComponent,
  TransactionListAdminComponent,
  TransactionViewAdminComponent,
  TransactionEditAdminComponent,
  TypeTransactionCreateAdminComponent,
  TypeTransactionListAdminComponent,
  TypeTransactionViewAdminComponent,
  TypeTransactionEditAdminComponent,
  CompteCreateAdminComponent,
  CompteListAdminComponent,
  CompteViewAdminComponent,
  CompteEditAdminComponent,
  ChequeEffetCreateAdminComponent,
  ChequeEffetListAdminComponent,
  ChequeEffetViewAdminComponent,
  ChequeEffetEditAdminComponent,
  PermutationCreateAdminComponent,
  PermutationListAdminComponent,
  PermutationViewAdminComponent,
  PermutationEditAdminComponent,
  PossedeCompteCreateAdminComponent,
  PossedeCompteListAdminComponent,
  PossedeCompteViewAdminComponent,
  PossedeCompteEditAdminComponent,
  PermutationItemCreateAdminComponent,
  PermutationItemListAdminComponent,
  PermutationItemViewAdminComponent,
  PermutationItemEditAdminComponent,
  TypeInstrumentCreateAdminComponent,
  TypeInstrumentListAdminComponent,
  TypeInstrumentViewAdminComponent,
  TypeInstrumentEditAdminComponent,
  BanqueCreateAdminComponent,
  BanqueListAdminComponent,
  BanqueViewAdminComponent,
  BanqueEditAdminComponent,
  ],
  entryComponents: [],
})
export class GestionchequeffetAdminModule { }
