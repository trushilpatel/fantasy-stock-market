<template>
  <div class="container-fluid py-5">
    <div class="p-3 row">
      <template v-for="data of stockData">
        <div
          :key="data.name"
          class="col-md-10 shadow d-inline-block ml-auto mr-auto pb-5 px-0"
        >
          <div
            class="text-center bg-dark text-white mb-4 py-3 font-weight-bold"
            style="font-size: 2rem"
          >
            {{ data.name }}
          </div>
          <div class="col-10 ml-auto mr-auto shadow py-3">
            <line-chart :data="data.data" :min="data.min" :max="data.max" />
          </div>
          <div class="py-3 ">
            <div class="row py-3 ">
              <div
                class="ml-auto mr-auto border py-3 px-5 shadow bg-dark text-white"
                style="font-size: 1.5rem"
              >
                You have :
                <span class="font-weight-bold">
                  {{ userStock[data.name].userShares }}
                </span>
                share
              </div>
            </div>
            <div v-if="operation === ''" class="row">
              <button
                class="btn btn-success ml-auto px-5 mr-4 py-2 rounded-0 border-0"
                v-on:click="doOperation('Buy')"
              >
                Buy
              </button>
              <button
                class="btn btn-danger mr-auto px-5 py-2 rounded-0 border-0"
                v-on:click="doOperation('Sell')"
              >
                Sell
              </button>
            </div>
            <!-- BUY SHARE -->
            <div v-if="operation === 'Buy'" class="my-3 row border-0">
              <div
                class="col-md-6 col-8 ml-auto mr-auto border p-0 mt-3 shadow"
              >
                <div class="input-group my-3 px-3">
                  <div class="input-group-text bg-dark text-white rounded-0">
                    Account Balance
                  </div>
                  <input
                    class="form-control rounded-0"
                    v-bind:value="balance"
                    disabled
                  />
                </div>
                <div class="input-group my-3 px-3">
                  <div class="input-group-text bg-dark text-white rounded-0">
                    Current Value
                  </div>
                  <input
                    class="form-control rounded-0"
                    v-bind:value="data.currentValue"
                    disabled
                  />
                </div>
                <div class="input-group px-3">
                  <div class="input-group-text bg-dark text-white rounded-0">
                    Number of shares
                  </div>
                  <input
                    type="number"
                    class="form-control rounded-0"
                    v-model.number="userStock[data.name].userSharesUpdate"
                    :max="userStock[data.name].maxBuyShares"
                    min="0"
                  />
                </div>
                <div class="text-muted ml-3">
                  maximum share you can
                  {{ operation }} {{ userStock[data.name].maxBuyShares }}
                </div>
                <div class="row px-3">
                  <div
                    class="btn btn-primary col-6 ml-auto rounded-0 px-5 mt-3 py-2"
                    @click="doOperation('')"
                  >
                    Close
                  </div>
                  <div
                    class="btn btn-success col-6 mr-auto rounded-0 px-5 mt-3"
                    @click="buyShares(data.name)"
                  >
                    Buy
                  </div>
                </div>
              </div>
            </div>

            <!-- SELL SHARE -->
            <div v-if="operation === 'Sell'" class="my-3 row border-0">
              <div
                class="col-md-6 col-8 ml-auto mr-auto border p-0 mt-3 shadow"
              >
                <div class="input-group my-3 px-3">
                  <div class="input-group-text bg-dark text-white rounded-0">
                    Account Balance
                  </div>
                  <input
                    class="form-control rounded-0"
                    v-bind:value="balance"
                    disabled
                  />
                </div>
                <div class="input-group my-3 px-3">
                  <div class="input-group-text bg-dark text-white rounded-0">
                    Current Value
                  </div>
                  <input
                    class="form-control rounded-0"
                    v-bind:value="data.currentValue"
                    disabled
                  />
                </div>
                <div class="input-group px-3">
                  <div class="input-group-text bg-dark text-white rounded-0">
                    Number of shares
                  </div>
                  <input
                    type="number"
                    class="form-control rounded-0"
                    v-model="userStock[data.name].userSharesUpdate"
                    :max="userStock[data.name].maxBuyShares"
                    min="0"
                  />
                </div>
                <div class="text-muted ml-3">
                  maximum share you can
                  {{ operation }} {{ userStock[data.name].userShares }}
                </div>
                <div class="row px-3">
                  <div
                    class="btn btn-primary col-6 ml-auto rounded-0 px-5 mt-3 py-2"
                    @click="doOperation('')"
                  >
                    Close
                  </div>
                  <div
                    class="btn btn-danger col-6 mr-auto rounded-0 px-5 mt-3"
                    @click="sellShares(data.name)"
                  >
                    Sell
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </template>
    </div>
  </div>
</template>

<script src="./MyWatchList.component.js" />
<style src="./MyWatchList.component.css" />
