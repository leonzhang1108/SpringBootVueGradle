<template>
  <div class="tabs">
    <span v-for='tab in tabs' class="tab"
      @click='tabClick'>
      {{tab.name}}
    </span>
  </div>
</template>
<script>
export default {
  name: 'Tabs',
  props: ['tabs', 'currentPath'],
  methods: {
    tabClick: function () {
      console.log(this.currentPath)
    }
  }
}
</script>
<style>
.tabs {
  text-align: left;
  padding: 10px;
  background: #DDDDDD;
}
.tab {
  background: #C0C0C0;
  padding: 5px 20px;
  border-radius: 8px;
  cursor: pointer;
}
.tab:hover {
  background: #969696;
}
.tab.current {
   background: #808080;
}
</style>


