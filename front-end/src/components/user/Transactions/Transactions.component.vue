<template>
  <div class="container-fluid py-5">
    <table class="table table-striped table-hover">
      <thead>
        <tr>
          <template v-for="field in transactionsFields">
            <th scope="col" :key="field">{{ field }}</th>
          </template>
        </tr>
      </thead>
      <tbody>
        <template v-for="transaction in transactions">
          <tr :key="transaction.timestamp" :class="transaction.transactionType" class="border-bottom border-dark">
            <template v-for="value in transaction">
              <td :key="transaction.timeStamp + value" :class="value">
                {{ value }}
              </td>
            </template>
          </tr>
        </template>
      </tbody>
    </table>
  </div>
</template>

<script src="./Transactions.component.js" />
<style src="./Transactions.component.css" />
