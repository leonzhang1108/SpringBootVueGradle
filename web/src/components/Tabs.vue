<template>
  <div class="tabs">
    <el-button v-for='tab in tabs' key={{$index}}
      @click='tabClick'>
      {{tab.name}}
    </el-button>
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

