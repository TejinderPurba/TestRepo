import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CashFlowComponent } from './cash-flow/cash-flow.component';
import { InsightsComponent } from './insights/insights.component';
import { MarketMoversComponent } from './market-movers/market-movers.component';
import { NetWorthComponent } from './net-worth/net-worth.component';
import { SummaryComponent } from './summary/summary.component';
import { InvestmentComponent } from './Investment/investment.component';

// All routes are inspected in strict order until a match is found
const routes: Routes = [
  {path:'', redirectTo: '/cash-flow', pathMatch:'full'},
  {path:'cash-flow', component:CashFlowComponent},
  {path:'market-movers', component:MarketMoversComponent},
  {path:'net-worth', component:NetWorthComponent},
  {path:'networth', component:NetWorthComponent},
  {path:'insights', component:InsightsComponent},
  {path:'summary', component:SummaryComponent},
  {path:'mynetworth', component:InvestmentComponent},
  {path:'**', redirectTo: '/summary', pathMatch:'full'} // put this in only when the other routes work!
];

@NgModule({
  imports: [RouterModule.forRoot(routes),],
  exports: [RouterModule]
})
export class AppRoutingModule { }
