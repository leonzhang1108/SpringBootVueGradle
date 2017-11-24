<template>
  <div>
    <TitleList :msgs="msgs">
      <div
        class="title"
        slot="msg"
        slot-scope="props"
      >
        parent{{props.index + 1}}: {{ props.content | capitalize }}
      </div>
    </TitleList>
    <ChildList 
      v-for="(msg, index) in msgs" 
      key='index' :child-msg='msg' 
      :index='index' 
      @onChildClick='childEvent' 
    >
      <div slot="header">this is header</div>
      <div slot="footer">this is footer</div>
    </ChildList>
  </div>
</template>

<script>
import TitleList from '@/components/Title'
import ChildList from '@/components/Child'
export default {
  name: 'ComponentDemo',
  components: {
    ChildList,
    TitleList
  },
  data () {
    return {
      msgs: [{
        content: 'first msg'
      }, {
        content: 'second msg'
      }, {
        content: 'thrid msg'
      }]
    }
  },
  watch: {
    msgs: {
      handler (newMsgs, oldMsgs) {
        newMsgs.forEach(msg => {
          console.log(msg.content)
        })
      },
      deep: true
    }
  },
  methods: {
    childEvent: function (index) {
      console.log('lalala')
      console.log(`the index is ${index}`)
    }
  },
  filters: {
    capitalize: function (value) {
      if (!value) return ''
      value = value.toString()
      return value.charAt(0).toUpperCase() + value.slice(1)
    }
  }
}
</script>
<style>
.title {
  font-size: 35px;
  font-weight: bold;
}
</style>
